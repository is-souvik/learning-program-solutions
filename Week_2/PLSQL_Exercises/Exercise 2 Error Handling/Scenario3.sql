CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id   IN NUMBER,
    p_name          IN VARCHAR2,
    p_balance       IN NUMBER
) AS
BEGIN
    INSERT INTO customers (customer_id, name, balance)
    VALUES (p_customer_id, p_name, p_balance);

    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        INSERT INTO error_log (error_message, error_date)
        VALUES ('Customer ID ' || p_customer_id || ' already exists', SYSDATE);
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO error_log (error_message, error_date)
        VALUES ('Error adding customer: ' || SQLERRM, SYSDATE);
END;
/
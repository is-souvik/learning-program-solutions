CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id   IN NUMBER,
    p_to_account_id     IN NUMBER,
    p_amount            IN NUMBER
) AS
    insufficient_funds EXCEPTION;
    v_balance NUMBER;
BEGIN
    -- Check balance of source account
    SELECT balance INTO v_balance FROM accounts WHERE account_id = p_from_account_id FOR UPDATE;
    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Deduct from source
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE account_id = p_from_account_id;

    -- Add to destination
    UPDATE accounts
    SET balance = balance + p_amount
    WHERE account_id = p_to_account_id;

    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        INSERT INTO error_log (error_message, error_date)
        VALUES ('Insufficient funds for account ' || p_from_account_id, SYSDATE);
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO error_log (error_message, error_date)
        VALUES ('Error during transfer: ' || SQLERRM, SYSDATE);
END;
/
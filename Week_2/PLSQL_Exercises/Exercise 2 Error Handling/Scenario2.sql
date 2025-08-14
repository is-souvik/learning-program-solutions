CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id   IN NUMBER,
    p_percent       IN NUMBER
) AS
    v_old_salary NUMBER;
BEGIN
    -- Try to get the current salary
    SELECT salary INTO v_old_salary FROM employees WHERE employee_id = p_employee_id FOR UPDATE;

    -- Update the salary
    UPDATE employees
    SET salary = salary + (salary * p_percent / 100)
    WHERE employee_id = p_employee_id;

    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        INSERT INTO error_log (error_message, error_date)
        VALUES ('Employee ID ' || p_employee_id || ' not found', SYSDATE);
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO error_log (error_message, error_date)
        VALUES ('Error updating salary: ' || SQLERRM, SYSDATE);
END;
/
BEGIN
  FOR rec IN (
    SELECT customer_id, loan_id, due_date
    FROM loans
    WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || rec.loan_id || ' for customer ' || rec.customer_id || ' is due on ' || TO_CHAR(rec.due_date, 'YYYY-MM-DD'));
  END LOOP;
END;
/
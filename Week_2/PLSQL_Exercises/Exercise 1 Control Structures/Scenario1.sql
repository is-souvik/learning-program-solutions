BEGIN
  FOR rec IN (SELECT customer_id, age, loan_interest_rate FROM customers) LOOP
    IF rec.age > 60 THEN
      UPDATE customers
      SET loan_interest_rate = loan_interest_rate - 1
      WHERE customer_id = rec.customer_id;
    END IF;
  END LOOP;
END;
/
BEGIN
  FOR rec IN (SELECT customer_id, balance FROM customers) LOOP
    IF rec.balance > 10000 THEN
      UPDATE customers
      SET IsVIP = 'TRUE'
      WHERE customer_id = rec.customer_id;
    END IF;
  END LOOP;
END;
/
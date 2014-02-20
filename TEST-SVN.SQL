SET Serveroutput ON
DECLARE
  v_big PLS_INTEGER ;
  v_small PLS_INTEGER;
  v_texto             VARCHAR(256);
TYPE lv_array_type IS varray(10) OF PLS_INTEGER;
lv_array lv_array_type:= lv_array_type('&num1','&num2','&num3');
j PLS_INTEGER;
lv_value PLS_INTEGER;
BEGIN
  j        :=0;
  lv_value :=0;
  FOR i IN 2 ..lv_array.COUNT
  LOOP
    BEGIN
      lv_value := lv_array(i);
      j        :=i;
      WHILE(j   > 1 AND (lv_array(j-1) > lv_value))
      LOOP
        BEGIN
          lv_array(j):= lv_array(j-1);
          j          :=j          -1;
        END ;
      END LOOP;
      lv_array(j):=lv_value;
    END;
  END LOOP;
  v_texto := 'O número mair é ' || lv_array(3) || '. E o menor é ' || lv_array(1);
  dbms_output.put_line(v_texto);
END;
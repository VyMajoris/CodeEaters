--SUMÁRIO>> 
/*
EX1 = IMCOMPLETO
EX2 = NÃO FEITO
EX3 = FEITO
EX4 = FEITO
EX5 = FETIO
EX6 = FEITO
EX7 = FEITO
EX8 = NÃO FEITO
EX9 = NÃO FEITO
EX10 = NÃO FEITO
*/
/*
1- Desenvolva um script que receba como parâmetro o código do departamento e retorne o nome do departamento,
o total de funcionários e o salário médio que paga. Utilize o pacote DBMS_OUTPUT.PUT_LINE para exibir o texto resultante.
Caso o código do departamento não esteja cadastrado na tabela, retornar a mensagem “NÃO EXISTE!”.
*/

create or replace function fun_dados_depto( p_cod_cli in number)
return sys_refcursor as
l_cursor sys_refcursor;
begin

open l_cursor for
  
  select count(d.cd_depto), d.nm_depto, avg(f.vl_salario) from loc_depto d, loc_funcionario f
where d.cd_depto = f.cd_depto
and d.cd_depto = 50
group by(d.nm_depto);

return l_cursor;
end;




DECLARE
  cursor_dados SYS_REFCURSOR;
  qtd_func number;
  avg_salario number(10,2);
  nm_depto varchar(10);
BEGIN

  LOOP
      FETCH cursor_dados INTO qtd_func, nm_depto, avg_salario;
       EXIT WHEN cursor_dados%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE(qtd_func || ' ' || nm_depto || ' ' || avg_salario );
    END LOOP;
END;


/*
3- Crie um script que armazene num vetor os números de Fibonacci entre dois números
inteiros e positivos informados pelo usuário. O vetor deve ser impresso no final do processo.
*/
SET Serveroutput ON
DECLARE
  TYPE FIBO_TIPO IS varray(100) OF NUMBER;
  fibo fibo_tipo := fibo_tipo();
  num1 pls_integer := 0 ;
  num2 pls_integer := 0 ;
  user_min pls_integer := &val_min;
  user_max pls_integer := &val_max;
  
  BEGIN
  num2 := 1;
  
  FOR i IN 1..20 LOOP
  
  if num1 > user_min then
  fibo.EXTEND;
  fibo(i):= 12;
  end if;
  
  if num1 < user_max then
  num1 := num1 + num2;
  num2 := num1 - num2;
  else
   EXIT;
  END if;
  
  END LOOP;

  for i in fibo.first..fibo.last
  loop
  dbms_output.put_line(fibo(i));
  end loop;
  
END;



/*
4- Desenvolva uma instrução SQL que exiba a quantidade total de locações realizadas por data do pedido.
Exiba somente as datas que tenham mais de 3 locações realizadas por dia.
*/

select dt_locacao, count(cd_cliente) from loc_pedido_locacao
HAVING count(cd_cliente) > 3
group by dt_locacao;

/*
5- Elabore script que receba um número e identifique se este número é primo.
*/

SET Serveroutput ON
CREATE OR REPLACE
  FUNCTION TEST_PRIMO(
      p_n IN NUMBER )
    RETURN NUMBER
  AS
    l_stop NUMBER := ceil(sqrt(p_n));
  BEGIN
  
    IF P_N = 1 THEN
      RETURN 0;
      
    ELSE
      IF P_N = 2 THEN
        RETURN 1;
      END IF;
    END IF;
    
    
    FOR i IN 2 .. l_stop
    LOOP
      IF ( mod(p_n,i) = 0 ) THEN
      
        RETURN 0;
      END IF;
    END LOOP;
    RETURN 1;
    
  END;
  
  
  
  BEGIN
    IF TEST_PRIMO(978) = 1 THEN
      dbms_output.put_line('É PRIMO');
    ELSE
      dbms_output.put_line('NÃO É PRIMO');
    END IF;
  END;

/*
6- Elabore script que receba três números e identifique o maior deles.
Caso dois ou três deles sejam idênticos, apresente a mensagem: “Há iguais!”.
*/
SET Serveroutput ON
CREATE OR REPLACE
PROCEDURE PROC_MAIOR_NUM(
    N1 IN NUMBER,
    N2 IN NUMBER,
    N3 IN NUMBER )
IS
BEGIN
  BEGIN
    IF( N1 = N2) OR(N1=N3) OR(N2=N3) THEN
      DBMS_OUTPUT.PUT_LINE( 'HÁ IGUAIS!');
      RETURN;
      ELSE
     DBMS_OUTPUT.PUT_LINE('O MAIOR NUMERO É ' || GREATEST(N1, N2, N3));
    END IF;
  END;
END PROC_MAIOR_NUM ;


begin
PROC_MAIOR_NUM(2,99,3);
end;


/*
7-	Elabore script que receba dois números e imprima os ímpares existentes entre ambos.
*/

SET Serveroutput ON
CREATE OR REPLACE
PROCEDURE PROC_MOSTRA_IMPAR(
    N1 IN NUMBER)
IS
BEGIN
DECLARE
WORK_N1 NUMBER := N1;
  BEGIN
    WHILE WORK_N1 != 0 LOOP
      IF mod(WORK_N1,2) != 0 THEN
        dbms_output.put_line(WORK_N1 || ' É IMPAR');
      END IF;
      WORK_N1 := WORK_N1 - 1;
    END LOOP;
  END;
END PROC_MOSTRA_IMPAR ;

begin
PROC_MOSTRA_IMPAR(10);
end;

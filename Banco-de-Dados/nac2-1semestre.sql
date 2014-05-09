--SUMÁRIO>> 
/*
EX1 = INCOMPLETO
EX2 = NÃO FEITO
EX3 = FEITO
EX4 = FEITO
EX5 = FETIO
EX6 = FEITO
EX7 = FEITO
EX8 = FEITO
EX9 = FEITO
EX10 = INCOMPLETO
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

/*
8-	Elabore uma função que receba como parâmetro o código de um funcionário e devolva como resposta o salário 
desse funcionário.
*/

CREATE OR REPLACE
  FUNCTION MOSTRA_SALARIO(
      cod_func IN loc_funcionario.cd_func%TYPE)
    RETURN NUMBER
  IS
    v_salario loc_funcionario.vl_salario%TYPE := 0;
  BEGIN
    SELECT vl_salario
    INTO v_salario
    FROM loc_funcionario
    WHERE cd_func = cod_func;
    RETURN v_salario;
  END MOSTRA_SALARIO;

  DECLARE
    g_sal NUMBER;
  BEGIN
    g_sal := MOSTRA_SALARIO(&Cd_Funcionario);
    dbms_output.put_line('O salário é ' || g_sal);
  END;
  
  
  
  
  /*
9-	Crie um script que armazene numa tabela auxiliar o valor total médio de locação relativos 
aos modelos de automóveis que foram locados (identificado por seu chassis). 
*/
  
  
  
  SET Serveroutput ON
DECLARE
  CURSOR c_medVeic
  IS
  
    SELECT v.nr_chassis, ROUND(AVG(i.vl_locacao), 2) medio
    FROM loc_item_locacao I ,  loc_veiculo v
    WHERE i.nr_placa = v.nr_placa
    GROUP BY v.nr_chassis;
    
  vMedio C_MedVeic%ROWTYPE;
  
TYPE tMedVeic
IS
  TABLE OF C_MedVeic%ROWTYPE INDEX BY BINARY_INTEGER;
  TAB_MedVeic tMedVeic;
  I NUMBER(10) :=0;
BEGIN
  OPEN C_MedVeic;
  LOOP
    FETCH C_MedVeic INTO vMedio;
    EXIT
  WHEN C_MedVeic%NOTFOUND;
    I                            := I + 1;
    TAB_MedVeic(I).nr_chassis := vMedio.nr_chassis;
    TAB_MedVeic(I).Medio       := vMedio.medio;
  END LOOP;
  CLOSE C_MedVeic;
  FOR J IN TAB_MedVeic.FIRST..TAB_MedVeic.LAST
  LOOP
    DBMS_OUTPUT.PUT_LINE('Chassis : ' || TAB_MedVeic(J).nr_chassis || '  ===== Valor médio total: ' || TAB_MedVeic(J).Medio );
  END LOOP;
END;


/*
10-	Desenvolva um script que receba como parâmetro o código do grupo de veículo e selecione o nome do grupo na 
tabela LOC_GRUPO, desde que esse grupo de veículos tenha ao menos uma locação realizada. Caso o código do grupo
não esteja cadastrado, parar o processamento emitindo a seguinte mensagem de erro “Código do grupo não está cadastrado”.
Já se estiver cadastrado e não possuir locação, indique também esta situação.
*/



SET Serveroutput ON
CREATE OR REPLACE PROCEDURE PROC_BUSCA_GRUPO(
    P_cd_grupo IN loc_grupo.cd_grupo%TYPE)
IS
BEGIN
  DECLARE
    W_CD_GRUPO NUMBER := P_cd_grupo;
    W_NR_PLACA LOC_VEICULO.NR_PLACA%TYPE;
    W_DS_GRUPO VARCHAR2(40);
    no_data_found  EXCEPTION;
    no_data_found2 EXCEPTION;
  BEGIN
    SELECT NVL(G.CD_GRUPO, 0),
      G.DS_GRUPO
    INTO W_CD_GRUPO,
      W_DS_GRUPO
    FROM LOC_GRUPO G
    WHERE P_cd_grupo = G.CD_GRUPO;
    IF w_cd_grupo    = 0 THEN
      RAISE no_data_found;
    ELSE
    
    
      SELECT DISTINCT NVL(I.NR_PLACA, '0')
      INTO W_NR_PLACA
      FROM LOC_ITEM_LOCACAO I,
        LOC_VEICULO V
      WHERE P_cd_grupo = V.CD_GRUPO
      AND I.NR_PLACA   = V.NR_PLACA
      and ROWNUM = 1;
      
      IF W_NR_PLACA = '0' THEN 
       
        RAISE no_data_found2;
         
      ELSE
      dbms_output.put_line('NOME DO GRUPO: ' || W_DS_GRUPO);
      END IF;
      
      
      
  END IF;
END;
END;




DECLARE
  no_data_found2 EXCEPTION;
  no_data_found  EXCEPTION ;
BEGIN
  PROC_BUSCA_GRUPO(8);
EXCEPTION
WHEN no_data_found THEN
  dbms_output.put_line('CODIGO NÃO CADASTRADO');
WHEN no_data_found2 THEN
  dbms_output.put_line('GRUPO NÃO POSSUI LOCAÇÕES');
END;

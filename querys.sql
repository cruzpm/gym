selecct *
select Nombre from usuarios where UserName= 'MarcoMancilla' and Password= '1234'

insert into registroes (idempleado, entrada) values (300, sysdate())

set @Edad := TIMESTAMPDIFF(YEAR,FechaNacimiento,curdate());

select TIMESTAMPDIFF(HOUR, '2016-09-04 14:55:40', '2016-09-04 18:55:40');

update empleados set pass = '1234'

select concat_ws(' ', Nombre, Apellidos) from empleados where IDEmpleado = '1' and pass = '1234'
select concat_ws(' ', Nombre, Apellidos) from empleados where IDEmpleado = '1' and pass = '12344'

insert into registroEs(salida, total) values (sysdate(), select TIMESTAMPDIFF(HOUR, '2016-09-04 14:55:40', '2016-09-04 18:55:40');)

select ID from registroes where fecha = '2016-09-04' and idempleado = '1'


select 


SELECT SEC_TO_TIME((TIMESTAMPDIFF(MINUTE, '2016-09-04 22:08:09.0', '2016-09-04 22:08:30.0'))*60)
SELECT SEC_TO_TIME((TIMESTAMPDIFF(minute, 
'2016-09-04 22:09:57.0', 
'2016-09-04 22:16:03.0')) * 60)

SELECT SEC_TO_TIME((TIMESTAMPDIFF(MINUTE,              h.h_inicio,                 h.h_fin))*60) AS diferencia 

select IDEmpleado from registroes where fecha = '2016-09-04' and idempleado = '9'

select *from registroes
 
select * from empleados where nombre = '1' or true

SELECT TIME_FORMAT(Time('4:31:16') - Time('3:25:19') ,'%h:%m:%s');



insert into registroes (idEmpleado, fecha, entrada, salida, total) values 
(9, '2016-08-29', '09:00:00', '17:00:00', '08:00:01');

select* from registroes where idEmpleado = 9 order by fecha asc

/** Detalle de registro de horas de emppleado */
select * 
from registroes 
where idEmpleado = '9' 
	and fecha >= '2016-09-01' and fecha <= '2016-09-15' 
order by fecha asc

/** Total de horas de empleado dentro de un rango de fecha */
SELECT SEC_TO_TIME(SUM(TIME_TO_SEC(total))) AS totalHours
from registroes 
where idEmpleado = '9' 
	and fecha >= '2016-09-01' and fecha <= '2016-09-15' 

/*Resta de horas**/
SELECT SEC_TO_TIME(TIME_TO_SEC('04:55:00') - TIME_TO_SEC('01:04:01')) AS totalHours 



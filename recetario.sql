DROP DATABASE IF EXISTS recetas;

CREATE DATABASE recetas CHARACTER SET utf8mb4;

USE recetas;

DROP TABLE IF EXISTS recetas.recetas;

CREATE TABLE recetas (
  id int(11) NOT NULL,
  nombre varchar(100) NOT NULL,
  ingredientes varchar(1000) NOT NULL,
  imagen varchar(50) NOT NULL,
  preparacion varchar(4000) NOT NULL,
  tipo ENUM ('OMNIVORA','VEGANA','VEGETARIANA')
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO recetas (id, nombre, ingredientes, imagen, preparacion, tipo) VALUES

(1, 'HUMMUS', '1 TARRO GARBANZOS<br>3 CS AOVE<br>1/2 LIMÓN EXPRIMIDO<br>1 AJO<br>1 CP SAL<br>1/2 CP COMINO<br>PEREJIL AL GUSTO<br>OPCIONAL: PIMENTÓN (DULCE O PICANTE) Y CANELA', 'hummus.png', 'PASAR TODOS LOS INGREDIENTES POR LA BATIDORA. SERVIR FRÍO CON UN CHORRITO DE ACEITE Y ESPOLVOREADO DE COMINO, PIMENTÓN Y/O CANELA. SE PUEDE ACOMPAÑAR DE PAN, CRUDITÉS DE VERDURAS, PALITOS...', 'VEGANA'),

(2, 'GAZPACHO', '1 LATA GRANDE DE TOMATE ENTERO PELADO<br>1 PIMIENTO ITALIANO<br>1 PEPINO<br>1/2 CEBOLLA<br>1 AJO<br>1 CS VINAGRE<br>1 VASO DE CHUPITO DE AOVE<br>3 CP SAL<br>OPCIONAL: ENTRE 1 Y 3 VASOS DE AGUA<br>OPCIONAL: 1 MENDRUGO DE PAN', 'gazpacho.png', 'LAVAR, PELAR Y CORTAR LAS VERDURAS FRESCAS. PASAR TODOS LOS INGREDIENTES POR LA BATIDORA, INCLUIDO EL JUGO DEL TOMATE ENLATADO. INSISTIR UNOS MINUTOS CON LA BATIDORA PARA QUE EL TRITURADO SEA FINO Y LA EMULSIÓN SEA DURADERA. SE PUEDE MODIFICAR LA DENSIDAD DEL GAZPACHO AÑADIENDO AGUA Y/O PAN Y VOLVIENDO A TRITURAR HASTA ALCANZAR EL PUNTO DESEADO. SERVIR BIEN FRÍO. SE PUEDE ACOMPAÑAR DE UNA PICADA DE CEBOLLA Y PIMIENTO. OPCIÓN VEGETARIANA: ACOMPAÑAR CON RALLADURA DE HUEVO COCIDO. OPCIÓN OMNÍVORA: ACOMPAÑAR CON VIRUTAS DE JAMÓN SERRANO.', 'VEGANA'),

(3, 'SATZIKI', '1 PEPINO<br>1 YOGUR NATURAL SIN ENDULZAR<br>1/2 LIMÓN EXPRIMIDO<br>1 MANOJO DE MENTA<br>3 CS AOVE<br>1 CP SAL<br>1/2 CP PIMIENTA MOLIDA', 'satziki.png', 'LAVAR Y PELAR EL PEPINO. RALLARLO CON UN RALLADOR DE TRAMA ANCHA. ES POSIBLE RALLARLO CON UNA TRAMA FINA O INCLUSO PASARLO POR LA TRITURADORA, PERO EN ESTE CASO SERÁ NECESARIO COLARLO DURANTE UNOS MINUTOS, PORQUE EXPULSARÁ MUCHA AGUA. MEZCLAR TODOS LOS INGREDIENTES. SERVIR BIEN FRÍO. SE PUEDE ACOMPAÑAR DE PAN, CRUDITÉS DE VERDURAS, PALITOS...', 'VEGANA'),

(4, 'BURGER VEGETAL', 'PARA 4 BURGERS<br>2 ZANAHORIAS<br>6 CHAMPIÑONES<br>3 CS AOVE<br>1 CP SAL<br>1/2 CP COMINO<br>1/2 CP CÚRCUMA<br>1/2 CP PIMENTÓN PICANTE', 'burger_vegetal.png', 'LAVAR Y PICAR EN DADOS LAS ZANAHORIAS Y LOS CHAMPIÑONES. OPCIONALMENTE SE PUEDEN PELAR LAS ZANAHORIAS. HERVIR LAS ZANAHORIAS EN AGUA DURANTE 10 MINUTOS Y AÑADIR LOS CHAMPIÑONES. COCER CONJUNTAMENTE DURANTE 10 MINUTOS MÁS, Y COLAR. EL AGUA DE COCER NO SE USARÁ MÁS ADELANTE EN LA RECETA, PERO OPCIONALMENTE SE PUEDE CONSERVAR PARA PREPARAR UN CALDO, UNA SALSA, ETC. ES IMPORTANTE QUE LA MASA NO SEA DEMASIADO LÍQUIDA PARA PODER DAR FORMA A LAS BURGERS, POR LO QUE HAY QUE ASEGURARSE QUE SE HA ESCURRIDO TODO EL AGUA. PARA ELLO, ES RECOMENDABLE DEJAR LAS ZANAHORIAS Y LOS CHAMPIÑONES EN UN COLADOR DURANTE UNOS 10 MINUTOS, Y DE ESTA MANERA TAMBIÉN SE ENFRIARÁN PARA PODER TRABAJAR CON ELLOS MÁS COMÓDAMENTE. UNA VEZ FRÍOS Y ESCURRIDOS, MEZCLAR CON EL RESTO DE INGREDIENTES HASTA CONSEGUIR UNA PASTA ESPESA. PARA ESTO ES POSIBLE UTILIZAR DIFERENTES MÉTODOS, COMO USAR UNA TRITURADORA O UN PASAPURÉ, O MACHACAR CON UN TENEDOR O UNA PRENSA DE PATATAS. CON ESTA MASA, DAR FORMA A LAS BURGERS CON LAS MANOS O UNA PRENSA, Y SELLAR VUELTA Y VUELTA EN LA SARTÉN CON UNA GOTA DE AOVE. ', 'VEGANA');

ALTER TABLE recetas
      ADD COLUMN tipo_id VARCHAR(256) NOT NULL;

UPDATE recetas
      SET tipo_id = (CASE 
        WHEN tipo = 'OMNIVORA' THEN 1
        WHEN tipo = 'VEGETARIANA' THEN 2
        WHEN tipo = 'VEGANA' THEN 3
        ELSE 0 END);


DROP TABLE IF EXISTS recetas.usuarios ;

CREATE TABLE usuarios (
  id int(11) NOT NULL,
  usuario varchar(30) NOT NULL,
  password varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO usuarios (id, usuario, password) VALUES
(1, 'admin', '1234'),
(2, 'lara', 'abcd');


ALTER TABLE recetas
  ADD PRIMARY KEY (id);

ALTER TABLE usuarios
  ADD PRIMARY KEY (id),
  ADD UNIQUE KEY usuario (usuario);

  --
ALTER TABLE recetas
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;


ALTER TABLE usuarios
  MODIFY id int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
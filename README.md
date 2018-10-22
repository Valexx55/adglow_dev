# Repositorio Formación Java ADGLOW 2018 

Este repositorio alberga los ejemplos prácticos desarrollados durante el curso así como la documentación teórica.

### Requisitos

JDK 8, Apache Tomcat 7.x, MySql 5.x

# Proyecto adglowjse

## Conceptos vistos 
IOC, DI, JCONFIG, CONTEXTO, @Autowired, @Component, TDD, @Test, @RunWith, Test unitarios e integrales

**Para ejecutar** Buscad las clases Main en sus respectivos paquetes. Las clases de test, con Junit (botón derecho --> Run as)

# Proyecto adglowjee

## Conceptos vistos
AOP, ViewResolver, Model, @Controller, @Service, @Repository, @ResquestMapping, @RequestBody, @ResponseBody, @Transactional, HTTP, MockMvc, @ContextConfiguration

**Para ejecutar** Hay que fijarse en la clase Controller y hacer las peticiones adHoc para invocar cada proceso. Si son peticiones GET, basta con un navegador en el que indicamos la URL esperada. Para invocar otros servicios lo más cómodo es usar PostMan o Advanced REST. Las clases de test, con Junit (botón derecho --> Rus as)


# Proyecto adglowrest

## Conceptos vistos
Servicios WEB Rest, @RestController, @PathVariable,,ResponseEntity, @Entity, JBossTools, Hibernate, JPA, @Valid, @Pattern, i18n, EntityManager, DTO, @JsonIgnore, HQL, NamedQuery, CascadeType, ID AutoIncremento vs Secuencia,FetchType, Mock, Test Suite

**Para ejecutar** Hay que fijarse en la(s) clase(s) Controller y RestController y hacer las peticiones adHoc para invocar cada proceso. Si son peticiones GET, basta con un navegador en el que indicamos la URL esperada. Para invocar otros servicios lo más cómodo es usar PostMan, Advanced REST o herramientas similares. Las clases de test, con Junit (botón derecho --> Rus as)


### Otros repositorio de referencia

-https://github.com/Valexx55/SpringGit5 (demos aop, testing)
-https://github.com/Valexx55/SPRING-AVANZADO-2017/tree/master/springbasics1 (IOC, DI, Spring en JSE)
-https://github.com/Valexx55/SPRING-AVANZADO-2017/tree/master/springbasics2 (Spring en JEE con Servlets)


### Documentación

[Enlace a la documentación](extra/FormacionJava2018.pdf)

### Scritps Base de datos

[Enlace a los scritps para generar las tablas de la base de datos](extra/script_sql_curso.sql)

**IMPORTANTE** Adaptar los parámetros del DataSource en el fichero /WebContent/WEB-INF/dispachter-servlet.xml a vuestro caso (cadena de conexión, puertos, usuario, contraseña) y revisar las dependecias del pom.xml para versiones MySql distintas de la 5**

### Agradecimientos

A DevAcademy, a todo el equipo @github/adlgow y especialmente todos los asistentes, por su actitud y su trato hacia mi persona durante el curso.


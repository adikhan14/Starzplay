# Starzplay

#This project required apache mvn, java 8 and oracle database 12c
#execute scripts.sql file with system user in oracle.
#Open project using any IDE and run com.demo.starzplay.Application class.

#Also you can build project from mvn clean install command and generate jar file in project target folder with name starzplay.jar and deploy it on any server.

#You can also use Apache derby by following changes.

#Change 1: In application.properties file do the following changes.

#spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
#spring.datasource.username=starzplay
#spring.datasource.password=secret
#spring.jpa.hibernate.ddl-auto=create
#spring.jpa.show-sql=true
#spring.jpa.properties.hibernate.format_sql=true
#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.Oracle12cDialect

spring.datasource.url=jdbc:derby:memory:local;create=true
spring.datasource.username=derbyuser
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.DerbyDialect

#Change 2: In pom.xml 

#comment below line.

		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc8</artifactId>
			<scope>runtime</scope>
		</dependency>
    
#uncomment below lines.

		<dependency>
			<groupId>org.apache.derby</groupId>
			<artifactId>derby</artifactId>
			<scope>runtime</scope>
		</dependency>


# SpringBoot elasticsearch example


### ElasticSearch
#### Create Index
```bash
curl -XPOST http://localhost:9200/travel
```

### Dependencies
```
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.0.M5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	
	...
	
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-elasticsearch</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
```

### API
#### Add user
```bash
curl -XPOST http://localhost:8080/travel/add -H'Content-Type: application/json' -d '
{
  "id": 1,
  "name": "HanSeunghyeon",
  "country": "KOR",
  "age": 42
}'
```

#### Find user
```bash
curl -XGET http://localhost:8080/travel/user/{id}
```

#### Delete user
```bash
curl -XDELETE http://localhost:8080/travel/user/{id}
```
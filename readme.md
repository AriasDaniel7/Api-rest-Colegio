# Api Rest Colegio

## Descripción:

Creacion de Api RESTfull usando Spring MVC y Spring Data JPA con MySQL (Spring Boot).

## Rutas:

### Curso

- Obtener todos los cursos

```http
GET http://localhost:8080/api/colegio/cursos
```

- Buscar un curso por id

```http
GET http://localhost:8080/api/colegio/curso/buscar/{id}
```

| Parametro | Tipo      | Descripción                          |
| :-------- | :-------- | :----------------------------------- |
| `id`      | `Integer` | **Requerido**: Id del curso a buscar |

- Obtener la cantidad de cursos

```http
GET http://localhost:8080/api/colegio/cursos/cantidad
```

- Crear un curso

```http
POST http://localhost:8080/api/colegio/curso/crear
```

Importante usar el siguiente Headers
| Key | Value |
| :------------- | :----------------- |
| `Content-Type` | `application/json` |

- Actualizar un curso

```http
PUT http://localhost:8080/api/colegio/curso/actualizar
```

Importante usar el siguiente Headers
| Key | Value |
| :------------- | :----------------- |
| `Content-Type` | `application/json` |

- Eliminar un curso

```http
DELETE http://localhost:8080/api/colegio/curso/eliminar/{id}
```

| Parametro | Tipo      | Descripción                            |
| :-------- | :-------- | :------------------------------------- |
| `id`      | `Integer` | **Requerido**: Id del curso a eliminar |

- Cuerpo del Json

```json
[
  {
    "id": 1,
    "nombre": "nombre del curso",
    "fechaInicio": "2023-10-10T05:00:00.000+00:00",
    "fechaFinal": "2023-10-10T05:00:00.000+00:00",
    "profesor": {
      "id": 1
    },
    "facultad": {
      "id": 1
    },
    "estudiantes": [
      {
        "id": 1
      },
      ...
    ]
  }
]
```

### Estudiante

- Obtener todos los estudiantes

```http
GET http://localhost:8080/api/colegio/estudiantes
```

- Buscar un estudiante por id

```http
GET http://localhost:8080/api/colegio/estudiante/buscar/{id}
```

| Parametro | Tipo      | Descripción                               |
| :-------- | :-------- | :---------------------------------------- |
| `id`      | `Integer` | **Requerido**: Id del estudiante a buscar |

- Obtener la cantidad de estudiantes

```http
GET http://localhost:8080/api/colegio/estudiantes/cantidad
```

- Crear un estudiante

```http
POST http://localhost:8080/api/colegio/estudiante/crear
```

Importante usar el siguiente Headers
| Key | Value |
| :------------- | :----------------- |
| `Content-Type` | `application/json` |

- Actualizar un estudiante

```http
PUT http://localhost:8080/api/colegio/estudiante/actualizar
```

Importante usar el siguiente Headers
| Key | Value |
| :------------- | :----------------- |
| `Content-Type` | `application/json` |

- Eliminar un estudiante

```http
DELETE http://localhost:8080/api/colegio/estudiante/eliminar/{id}
```

| Parametro | Tipo      | Descripción                                 |
| :-------- | :-------- | :------------------------------------------ |
| `id`      | `Integer` | **Requerido**: Id del estudiante a eliminar |

- Cuerpo del Json

```json
[
  {
    "id": 1,
    "nombre": "Nombre estudiante",
    "edad": 20,
    "genero": "M",
    "correo": "correo@correo.com"
  }
]
```

### Profesor

- Obtener todos los profesores

```http
GET http://localhost:8080/api/colegio/profesores
```

- Buscar un profesor por id

```http
GET http://localhost:8080/api/colegio/profesor/buscar/{id}
```

| Parametro | Tipo      | Descripción                             |
| :-------- | :-------- | :-------------------------------------- |
| `id`      | `Integer` | **Requerido**: Id del profesor a buscar |

- Obtener la cantidad de profesores

```http
GET http://localhost:8080/api/colegio/profesores/cantidad
```

- Crear un profesor

```http
POST http://localhost:8080/api/colegio/profesor/crear
```

Importante usar el siguiente Headers
| Key | Value |
| :------------- | :----------------- |
| `Content-Type` | `application/json` |

- Actualizar un profesor

```http
PUT http://localhost:8080/api/colegio/profesor/actualizar
```

Importante usar el siguiente Headers
| Key | Value |
| :------------- | :----------------- |
| `Content-Type` | `application/json` |

- Eliminar un profesor

```http
DELETE http://localhost:8080/api/colegio/profesor/eliminar/{id}
```

| Parametro | Tipo      | Descripción                               |
| :-------- | :-------- | :---------------------------------------- |
| `id`      | `Integer` | **Requerido**: Id del profesor a eliminar |

- Cuerpo del Json

```json
[
  {
    "id": 1,
    "nombre": "Nombre del profesor",
    "genero": "M",
    "edad": 25,
    "telefono": 1234567890,
    "correo": "correo@correo.com"
  }
]
```

### Facultad

- Obtener todos las facultades

```http
GET http://localhost:8080/api/colegio/facultades
```

- Buscar una facultad por id

```http
GET http://localhost:8080/api/colegio/facultad/buscar/{id}
```

| Parametro | Tipo      | Descripción                               |
| :-------- | :-------- | :---------------------------------------- |
| `id`      | `Integer` | **Requerido**: Id de la facultad a buscar |

- Obtener la cantidad de facultades

```http
GET http://localhost:8080/api/colegio/facultades/cantidad
```

- Crear una facultad

```http
POST http://localhost:8080/api/colegio/facultad/crear
```

Importante usar el siguiente Headers
| Key | Value |
| :------------- | :----------------- |
| `Content-Type` | `application/json` |

- Actualizar facultad

```http
PUT http://localhost:8080/api/colegio/facultad/actualizar
```

Importante usar el siguiente Headers
| Key | Value |
| :------------- | :----------------- |
| `Content-Type` | `application/json` |

- Eliminar una facultad

```http
DELETE http://localhost:8080/api/colegio/facultad/eliminar/{id}
```

| Parametro | Tipo      | Descripción                                 |
| :-------- | :-------- | :------------------------------------------ |
| `id`      | `Integer` | **Requerido**: Id de la facultad a eliminar |

- Cuerpo del Json

```json
[
    {
        "id": 1,
        "nombre": "nombre facultad",
        "descripcion": "descripcion",
        "misionYvision": "misionYvision",
        "objetivo": "objetivo",
        "estudiantes": [
            {
                "id": 1
            }
            ...
        ]
    }
]
```

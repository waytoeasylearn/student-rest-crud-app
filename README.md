# student-rest-crud-app
Student Rest CRUD App
## Create Student
**POST Request**
```
localhost:8080/api/students
```
**Request Body**
```
{
    "name": "Ashok Kumar",
    "class": "10th",
    "subjects": [
        {
            "name": "Telugu",
            "marks": 89
        },
        {
            "name": "English",
            "marks": 96
        }
    ]
}
```

## Get All Students
**GET Request**
```
localhost:8080/api/students
```

## Get Students by name
**GET Request**
```
http://localhost:8080/api/students/Ashok%20Kumar
```
## Get Students whose marks greater than given marks
**GET Request**
```
http://localhost:8080/api/students/totalmarks?gt=130
```
## Get Students by class name
**GET Request**
```
localhost:8080/api/students/class?class=10th
```

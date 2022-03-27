# student-rest-crud-app
Student Rest CRUD App
## Create Student
**POST Request**
```
localhost:8080/api/students
```
Input JSON
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

## Create Student
**GET Request**
```
localhost:8080/api/students
```

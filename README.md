# PROBLEM STATEMENT

I want to join two JPA/hibernate entities using columns from embedded object.

Target query should look like:
```postgresql
SELECT * 
FROM document d
JOIN person p on p.object_id = d.object_id and p.object_type = d.object_type
```
So I can then easily get person from document.

The data model already exists and cant be changed.

# course-system-web-app-mandatory-2
A digital system to handle courses at a fictive university.  

## Users and their levels:
- **Admin**: _Should be able to accept a student that have applied for a course._ ***This is not done.***
  - Username: _admin_
  - Passord: _admin_
- **Student**: _A student can see a list of courses and apply for the courses._
  - Username: _student_
  - Passord: _student_
- **Teacher**: _A teacher can create, edit, and delete a course._
  - Username: _teacher_
  - Passord: _teacher_
  
## Search:
You can search for courses on their course name in danish. Try it out.
When you search you get redirected to `/student/courses/?search={YOUR_INPUT}`.

## Access
When logged in as a teacher you can't access something with the path of admin `/admin/...`.
The same goes for the other users and their respective paths `/student/...` and `/teacher/...`

## Problems to watch out for:
- A course can't be deleted if a student has applied for the course. So it fails because a reference in `student_courses` table needs to be removed. We tried to figure it out, but couldn't find out in time and therefore we state the problem here. 
- Admin has no further functionality than logging in. 
- We had some path problems for the student upon sending a request, so we allowed everyone to access a 3 layered path with spring security. So all users can access `/student/***`, a * is a layer on the path = `/student/{LAYER}/{LAYER}/{LAYER}`
- The path `/teacher/courses/` can also be accessed by all users. 

# Job Portal Project

This is a simple Job Portal web application built with:

- **Backend:** Java Spring Boot with MongoDB Atlas
- **Frontend:** HTML, CSS, and vanilla JavaScript

---

## Features

- **Hire Profile:** Post new job profiles including job description, experience required, and skills (multi-select).
- **Get Job Now:** Browse and search job postings stored in MongoDB.
- **Search:** Search job posts by profile, skills, or description.
- **MongoDB Atlas:** Cloud-hosted MongoDB as database.

---

## Setup Instructions

### Backend

1. Clone this repository.
2. Configure your MongoDB Atlas connection string in `application.properties`.
3. Run the Spring Boot application using:

```bash
./mvnw spring-boot:run
# or
mvn spring-boot:run

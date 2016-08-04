## JSON / REST Labs
### Lab 1: REST w/ Java
- Add a CourseDao with all CRUD operations
  - Create
  - Read one
  - Read all
  - Update
  - Delete
- Write a tests to execute and verify all methods of your new DAO

### Lab 2: REST w/ cUrl
- From the command line use curl to perform each of the CRUD operations on courses. (hint: make sure to use -H 'ContentType: application/json' for create and update.)
  - Create
  - Read one
  - Read all
  - Update
  - Delete (warning: if you delete a course that contains people, those people will be automatically deleted)
- Write down the HTTP response codes returned from each of those curl commands

### Lab 3: JSON parsing
- Get data from one of these APIs https://github.com/toddmotto/public-apis
- Pull out some information that interests you and present it from a command line program (i.e. public static main).

### Lab 4: More cUrl and HTTP requests
- Use curl to view a form that you created in the last class
- Use curl to submit that form (hint: use Chrome dev tools Network tab to see what information needs to get passed with the request.)
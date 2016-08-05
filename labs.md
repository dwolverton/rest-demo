## JSON / REST Labs
### Lab 1: REST w/ Java
- First, fix my code so that RestOperationsTest passes. The test is correct, but you will need to implement PersonDaoGsonImpl.getAll(). Right now it is just a stub.
- Add a CourseDao with all CRUD operations
  - Create
  - Read one
  - Read all
  - Update
  - Delete
- Write tests to execute and verify all methods of your new DAO

### Lab 2: REST w/ cUrl
- From the command line use curl to perform each of the CRUD operations on courses. (hint: make sure to use -H 'ContentType: application/json' for create and update.)
  - Create
  - Read one
  - Read all
  - Update
  - Delete (warning: if you delete a course that contains people, those people will be automatically deleted)
- Write down the HTTP response codes returned from each of those curl commands

### Lab 3: JSON parsing
- Here's a list of free APIs https://github.com/toddmotto/public-apis
- Use the Drone Strike API http://dronestre.am/ to complete these exercises:
  1. Print the location and narrative or the first strike in the list
  2. Print the location of the fifth strike in the list
  3. Print out how many drone strikes took place in each country
  4. Print out how many drone strikes took place each year
  5. Print the location and narrative of all strikes where at least 10 people were killed

### Lab 4: More cUrl and HTTP requests
- Use curl to view a form that you created in the last class
- Use curl to submit that form (hint: use Chrome dev tools Network tab to see what information needs to get passed with the request.)
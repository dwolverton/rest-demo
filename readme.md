# JSON / REST Demo Client
### Setup
1. Install json-server

    ```
    npm install -g json-server
    ```

2. Copy db-init.json and name the new file "db.json".
3. Run json-server

	```
    json-server --watch db.json
    ```

4. Now The rest server is available at http://localhost:3000, with resources http://localhost:3000/people and http://localhost:3000/courses

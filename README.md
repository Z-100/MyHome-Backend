# :house: MyHome
### Information for tpangri ***Important*** 
***All commits after [Release V1.0.0](https://github.com/Z-100/MyHome-Backend/releases/tag/V1.0.0) are in no association to the "School project version", as I want to continue developement on this REST API.***
<br/>
### ***The other repositories***
- ![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white) [The Android "front-end" application](https://github.com/Z-100/MyHome-Android-App)
- :house: [Back to MyHome](https://github.com/Z-100/MyHome)

## What is MyHome
All around, MyHome is a school project consisting of two standalone project:
* The RESTful API (this project)
  * Requests can be sent to the API, on which a json response is being sent back.
* And a standalone android app
  * The app sends those request to the API and transforms the json response to something viewable
  
### Features of the API
* #### Can be connected to MariaDB (Has been tested and is used in this project)
  * Other DB systems have not been tested yet
* #### The various access points ***Important for devs!***
  * /account
    * /getAcc (testing purposes only)
    * /login (Respose is the accounts token on success)
      * Required headers:
        * email, password, token (hard coded)
    * /register (Response is the accounts token on success)
      * Required headers:
        * email, password, newHouseName, defaultMemberName, token (hard coded)
  * /member
    * /get-member (Responds with all members belonging to an account)
      * Required headers:
        * email, token (for validation and account search)
  * /meal
    * /get-meal (Responds with all meals belonging to a specific member)
      * Required headers:
        * memberId (Can be found in /get-member response), email, token
  * /recipe
    * /get-recipes (Responds with all the recipes belonging to a house (hold))
      * Required headers:
        * email, token
    * /get-recipe (Responds with all the recipes with a rating above *)
      * Required headers:
        * getRating (The rating to search for), email, token
  * /room (Responds with all rooms belonging to a house (hold))
    * Required headers:
      * email, token
  * /item
    * /list-all-items (Responds with all items belonging to house (hold))
      * Required headers:
        * email, token
  * /shopping-list
    * /get-shopping-list (Responds with all items with a count of under 10 of them existing)
      * Required headers:
        * email, token
* ### How to update the database
  * Currently (as for the school project) You can only edit, delete or insert new members via:
  * /member
    * /delete-member
    * /update-member
    * /insert-member

### School information
* All the diagrams, sketches and the documentation can be found in this [repository](https:github.com/Z-100/MyHome)
* This repository consists 100% out of z-100's code
  * Including the database
* The Frontend repository consists partially out of andy's and z-100's code

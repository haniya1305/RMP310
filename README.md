# RateMyPritch

## What are we about?
Our project is a rating app for the Pritchard Dining Hall. We noticed that with the variety of food, it can often times be confusing as to what to pick and which foods fit dietary restrictions. Our rating app aims to ease those concerns, with a few clicks of a button, you can rate Pritchard items to see which ones are the right fit for you!

## How to run the code?
Our code's final product will be an APK file that can run on android devices. Currently, we are using Android Studio's mobile device emulator to emulate a real phone as we make adjustments to the app.

## What we've done so far?
We worked through the implementation of the interaction between pages that we first designed on Figma. Once we were happy with our UI design, we divided the work between team members to design the XML pages and then worked on its implementation. 

However, from our last design, we didn't have a proper system for login/signup as well as the review database system. We also just had one dish that is a Pritchard usual that was being reviewed and saved using intents from Android Studios.

In this verison of our project, we worked through the database systems for the login/signup, webscraping through the NutriSlice for the daily menu items, and working through the database connection for the review system. We researched and learnt more about database systems using SQLite and MySQl for both the databases and __ for the webscraping.

**List of Features worked on for this version:**
- Login/Signup Database System
  Used SQLite to stores the signup information and allows users to login to make reviews. Information is stored on the database and can be accessed even once the program is reopened. Implemented via the DBHelper class created.
  Outputs for the Login System -
  

  <img src = "https://user-images.githubusercontent.com/69047981/201797430-429c9232-1f3f-4b24-9e3f-27fe1960ca4b.jpeg" width = "170"/>
  <img src = "https://user-images.githubusercontent.com/69047981/201797446-6ee10842-7aa5-4837-8a4b-865d394cbd6f.jpeg" width = "170"/>
  <img src = "https://user-images.githubusercontent.com/69047981/201797468-d296c17f-776b-4e71-b47c-5e533e25916c.jpeg" width = "170"/>
  <img src = "https://user-images.githubusercontent.com/69047981/201797474-01de3bd2-c894-453b-9ad4-acce60fbbdf7.jpeg" width = "170"/>
  <img src = "https://user-images.githubusercontent.com/69047981/201797483-b34b5112-0ac8-4708-812b-d3adf0295a49.jpeg" width = "170"/>

  
- Database System for the Reviews to be stored
  
- Webscraping Nutrislice
  


## Class Organization
Our classes are organized by each unique page our users will encounter throughout their use of our app. 
Our classes are as follows:
- AssignReview (Assign reviews page)
- CurrentReviews (List of Current Reviews for a Particular Item)
- MainView (The apps homescreen which includes different departments, meal of the day, time and home and settings)
- LandingPage (Sign-up page with option to continue without signing up)
- My_Reviews (List of users current reviews as well as user control buttons)
- Sign_Up_Page (Sign up page)

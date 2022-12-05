# RateMyPritch

## Haniya -, 65819849
## COSC 310 Individual Project

## What are we about?
Our project is a rating app for the Pritchard Dining Hall. We noticed that with the variety of food, it can often times be confusing as to what to pick and which foods fit dietary restrictions. Our rating app aims to ease those concerns, with a few clicks of a button, you can rate Pritchard items to see which ones are the right fit for you!

## How to run the code?
Our code's final product will be an APK file that can run on android devices. Currently, we are using Android Studio's mobile device emulator to emulate a real phone as we make adjustments to the app.

## What we've done so far?
We worked through the implementation of the interaction between pages that we first designed on Figma. Once we were happy with our UI design, we divided the work between team members to design the XML pages and then worked on its implementation. 

However, from our last design, we didn't have a proper system for login/signup as well as the review database system. We also just had one dish that is a Pritchard usual that was being reviewed and saved using intents from Android Studios.

We then worked through the database systems for the login/signup, webscraping through the NutriSlice for the daily menu items, and working through the database connection for the review system. We researched and learnt more about database systems using SQLite and MySQl for both the databases and for the webscraping.

## Class Organization
Our classes are organized by each unique page our users will encounter throughout their use of our app. 
Our classes are as follows:
- AssignReview (Assign reviews page)
- CurrentReviews (List of Current Reviews for a Particular Item)
- MainView (The apps homescreen which includes different departments, meal of the day, time and home and settings)
- LandingPage (Sign-up page with option to continue without signing up)
- My_Reviews (List of users current reviews as well as user control buttons)
- Sign_Up_Page (Sign up page)

## Individual Project

**Feature** - Directions from a student in UBC Vancouver to Pritchard Dining hall that this app has information about.
**APIs Used** - Google Directions API and Retrofit

In this version, I worked on a version of the RateMyPritch project by adding a directions option to help users find their way to have a bite at the famous Pritchard Dining Hall. I used the Google Directions API along with the Retrofit API to do so. I had to change and build gradles in order to then create an API key to access the google developers code chunks. Then, I created new java files, which are Result, Route and OverviewPolyline to help me create the objects I needed in the Map.java class, said objects being googleMap, apiInterface, list of latitude & longitude and polylineoptions. I used the retrofit API to build a new callAdapterFactory using Google APIs, this was used to create the APInterface. 

Google Directions API - The Google Directions API is a web service that uses an HTTP request to return JSON or XML-formatted directions between locations. To implement it, I first had to create an API key and placed it in the strings.xml file to access the API resources; additionally I also had to activate internet permissions on Android Studios Manifest file. I added the gradle dependencies I needed for the feature implementation and synced them, now I would be able to work with this API. I then created the required java files to run my functionalities.

Retrofit - Retrofit is a REST Client for Java and Android API allowing to retrieve and upload JSON (or other structured data) via a REST based You can configure which converters are used for the data serialization. I used the Retrofit API to create an interface to implement the Directions API and files that I created earlier. I used the .build() function to create the apis from the url.

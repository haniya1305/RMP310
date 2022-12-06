# RateMyPritch

### Haniya -, 65819849
### COSC 310 Individual Project

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

**Feature** - Directions from a student in UBC Vancouver to Pritchard Dining hall that this app has information about. Additionally, helps the user keep their reviews accurately worded by implementing a spell checker for grammatical errors, along with a weather forecast to the home page which will help users figure out how many layers they need to reach the dining hall without having a frostbite!



**APIs Used** - Google Directions API, Retrofit, JSpell and Weather


**Description** -

In this version, I worked on a version of the RateMyPritch project by adding a directions option to help users find their way to have a bite at the famous Pritchard Dining Hall. I used the Google Directions API along with the Retrofit API to do so. I had to change and build gradles in order to then create an API key to access the google developers code chunks. Then, I created new java files, which are Result, Route and OverviewPolyline to help me create the objects I needed in the Map.java class, said objects being googleMap, apiInterface, list of latitude & longitude and polylineoptions. I used the retrofit API to build a new callAdapterFactory using Google APIs, this was used to create the APInterface. A newer feature added is the spell checker which makes sure all reviews are formatted and worded correctly so that the essential feature of allowing students to voice their opinions and look for reviews is handled correctly in the sense that they can understand what the other person is saying. As the other new feature is similar to the spellchecker, I was able to easily incorporate the weather API. It is mainly included to help students prepare for their walk down from say the tip of Cassiar down to a fun meal at Pritchard!



**APIs** -

Google Directions API - The Google Directions API is a web service that uses an HTTP request to return JSON or XML-formatted directions between locations. To implement it, I first had to create an API key and placed it in the strings.xml file to access the API resources; additionally I also had to activate internet permissions on Android Studios Manifest file. I added the gradle dependencies I needed for the feature implementation and synced them, now I would be able to work with this API. I then created the required java files to run my functionalities.

Retrofit - Retrofit is a REST Client for Java and Android API allowing to retrieve and upload JSON (or other structured data) via a REST based You can configure which converters are used for the data serialization. I used the Retrofit API to create an interface to implement the Directions API and files that I created earlier. I used the .build() function to create the apis from the url.

JSpell - JSpell is an API used for basic spell check and finding grammatical errors. I implemented it using RapidAPI, generated the API key by creating an account and then implementing the code for creating a request to use the data and then build it. I then created the functions required to make the toast messages in order to alert the user about the number of errors in their text.

Weather By Zip Code - This is an api I found that would help students know what the temperature is before they decide to go to the dining hall to eat their meal. Ideally, as they see the menu before leaving, it will help them decide if they need a jacket or extra layers.  I implemented it using RapidAPI, generated the API key by creating an account and then wrote the code for creating a request to use the data and then build it. I then created the functions required to make the textview messages in order to print a string on textView which is the current temperature.

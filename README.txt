# REStoreEmployeeApp

2019/04/08
- Created Project
- Added Git repository
- Setup LoginView Class
- Setup User Class
- Began Setting up database connection using Volly
- Designed Login window

2019/04/09
- Setting up Volley to be used for request and respond to database
- Finished Volley *to be tested*, Added Internet Permissions to App Manifest
- Setup Main Menu Class + View
- Created php script to communicate between database and applicatetion: \RELogin.php
- Established connection with phpscript on backend 
- Fixed bug with volley
- Added Call Nearest Manager Button to Main Menu
- Added Calling permissions to App Manifest

2019/04/10
- Created mysql database[RE_StoreEmployees] to store App Data.
- Finished Login, may only login if user exists in database (email and password are correct)
- Created Menu Item class that will represent the each item of the menu in the Main Menu
- Added Cardview design for each menu item
- Created RecyclerViewAdatperMainMenu

2019/04/11
- Finished recyclerview

2019/04/12
- Made Scrolling horizional in menu
- Populated Menu with Items (Subject to change)
- Created menu items
- Changed to GridLayoutManager from Linear Horizonal
- ReDesigned MainMenu


2019/04/14
- Created ActionBar (Top Toolbar) -> will have app options such as change language
- Added SnapHelper to help with smooth menu item transition
- Redesigned MainMenu

2019/04/15
- Created Information Fragment
- Created Co-Workers Fragment	
- Changed MainMenu to horizonal orientation
- Created RecyclerViewAdapterUsers to display all users
- Desgined Users CardView

- TODO Created Training Fragmnet
- TODO if manager RecyclerView add more items for management
- TODO Create Avaliable Training list and completed training list, new training will appear in availiable training
- TODO Change recyclerview to vartical to elimiated ugly white space above and under
- TODO Change topbar REStoreEmpployementApp to Welcome (UserName)
- TODO BackEnd for Admin
- TODO Allow users to change profile picture
- TODO Change Menu Style in options -> eg  Linear to Grid
     Change Horizonal to Vertical?
- TODO change REService to Images of Food Repairs Shopping
- TODO Remove Certificate Quiz -> will be part of training
- TODO Add options?

- TODO add employee information? 
-> Name, Level, total sales other information on top section
-> Move recycler View to button section
- TODO Create CoWorkers/Contacts list with fragment for each name having name, title, map location etc
- TODO Include VOIP calling in contacts & ?remove voip button?
 
- TODO hidden layout control buttons
- TODO new user mandatory info +  test
- TODO Recycler View menu, with Call button on buttom and user menu (Fragment?) on top with dropdownlist
- TODO Different Employee Levels
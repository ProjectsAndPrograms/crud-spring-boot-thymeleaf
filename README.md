## Ideas
 Ideas an social media website, where users can share their ideas to everyone.


## Technolgies Used 
  1. PHP (8.2)
  2. Laravel-10
  3. Blade templating engine
  4. MySQL database
  5. Bootstrap 5
  
## Screenshots
### Users
<div style="display: flex;flex-direction: column; grid-gap: 10px;">
    <div style="display: flex; grid-gap: 10px;">
        <img src="images/1.png" alt="screenshots" width="49%" style="border: 2px solid lightgreen"/>
        <img src="images/2.png" alt="screenshots" width="49%" style="border: 2px solid lightgreen"/>
    </div>
    <div style="display: flex; grid-gap: 10px;">
        <img src="images/3.png" alt="screenshots" width="49%" style="border: 2px solid lightgreen"/>
        <img src="images/8.png" alt="screenshots" width="49%" style="border: 2px solid lightgreen"/>
    </div>
     <div style="display: flex; grid-gap: 10px;">
        <img src="images/9.png" alt="screenshots" width="49%" style="border: 2px solid lightgreen"/>
        <img src="images/10.png" alt="screenshots" width="49%" style="border: 2px solid lightgreen"/>
    </div>
</div>
<br>




### Admin
<div style="display: flex;flex-direction: column; grid-gap: 10px;">
    <div style="display: flex; grid-gap: 10px;">
        <img src="images/4.png" alt="screenshots" width="49%" style="border: 2px solid lightgreen"/>
        <img src="images/5.png" alt="screenshots" width="49%" style="border: 2px solid lightgreen"/>
    </div>
    <div style="display: flex; grid-gap: 10px;">
        <img src="images/6.png" alt="screenshots" width="49%" style="border: 2px solid lightgreen"/>
        <img src="images/7.png" alt="screenshots" width="49%" style="border: 2px solid lightgreen"/>
    </div>
</div>
<br>

## HOW TO USE?


 Step-1: **[Install Composer](https://getcomposer.org/)** <br>
 Step-2: **[Install PHP and MySQL OR simply xampp](https://www.apachefriends.org/download.html)**<br>
 Step-3: open XAMPP start Apache server and MySQL database<br>
 Step-4: create database called <b>'ideas'</b> : open browser -> search -> <b>'localhost/phpmyadmin'</b> -> new -> under the database name type <b>'ideas'</b> -> create<br>

Installation

    Clone the Repo:
    > git clone https://github.com/ProjectsAndPrograms/Ideas.git
    > cd Ideas
    > composer install or composer update
    > cp .env.example .env
    > Set up .env file
    > php artisan key:generate
    > php artisan storage:link
    > php artisan migrate:fresh --seed
    > php artisan serve
    http://127.0.0.1:8000/

<br>
setup your .env file correctly it contains database credentials


## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.




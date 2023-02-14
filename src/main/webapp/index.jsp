<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>


<html lang="sv">
<link rel="stylesheet" href="css/main.css"/>

<head>
  <title>Antons Skafferi</title>
</head>

<header>
  <div class = "header-tittle-container">
    <div class="header-tittle">
       <a href="url"class="table-booking">Boka Bord</a>
      <img src="AntonsSkafferi.svg" alt="Antons Skafferi logo">

    </div>
  </div>
</header>
<body>

<main class ="wrapper">
  <section class ="menu-container">
    <div class = "menu-card">
      <h1 class ="menu-tittle">Dagens Lunch</h1>
      <div class ="menu-week">
        <p class ="week-number">Vecka </p>
        <p class ="header-open-hours-lunch">Man-Fre: 11:00 - 14:00</p>
      </div>
      <div class = "menu-items">
        <p class ="menu-day">Man:</p>
        <li class ="menu-course">Fisk- och skaldjursgryta med saffran &
          pressad potatis <span class="menu-price">99 SEK</span></li>
        <div></div>

        <li class = "menu-course">Schnitzel av kycklingfile med currydressing
          & valfri potatis <span class="menu-price">99 SEK</span></li>
        <div></div>

        <li class ="menu-course"> Bakad Rotselleri, Stuvad Gronkal, Picklad
          Rodlok <span class="menu-price">99 SEK</span> </li>
        <div></div>




      </div>
      <div></div>
      <a href="weekMenu.html" class= "week-menu">Se hela veckans meny</a>

    </div>

    <img
      src = "img/lunch.jpg"
      class="card-image"
      id = "menu-image"
      alt=""
    />
  </section>
</main>
<main class ="wrapper1">
  <img
    src = "img/event.jpg"
    class="event-image"
    id = "event-image"
    alt=""
  />

  <section class ="event-container">
    <div class = "event-card">
      <h1 class ="event-tittle">Evenemang</h1>
      <div class ="event-day">
        <p class ="event-date"> Fredag 14 februari </p>
        <p class ="event-time">18:00</p>
      </div>
      <div class = "event-describing">
        <p class ="event-info">Upplev en helkvall med god mat och
          show i bekvam miljo pa Antons Skafferi.</p>
        <p class ="event-info"> Vi bjuds det pa musik ifran Anton och
          hans gang. Det spelas svenska folkvisor
          kanda som okanda. Kl 18 borjar
          musiken och avslutas vid 22.00. Passa
          pa att redan nu boka bord innan det blir
          fullt.</p>


      </div>

      <p class= "other-event">Se alla kommande evenemang</p>

    </div>

  </section>
</main>
<main class="wrapper1">
  <figure>
    <img
      src = "img/lacarte.jpg"
      class="lacarte-image"
      id = "lacarte-image"
      alt=""
    />
    <figcaption class="lacarte-menu"> la Carte Meny </figcaption>
  </figure>



</main>
<main class = "wrapper2">
  <footer>
    <div class="footer-container">
      <div class="contact-info">
        <h3>Kontakt</h3>
        <p>Telefon: 010 34 34 34</p>
        <p>Email: Antonsskafferi@gmail.com</p>
      </div>
      <div class="address">
        <h3>Adress</h3>
        <p>Storgatan 12</p>
        <p>855 33 Sunsvall</p>
      </div>
      <div class="hours">
        <h3>Oppettider</h3>
        <p>Man-tors: 11:00 - 21:00</p>
        <p>Fre-lor: 11:00 - 00:00</p>
        <p>Son: Stangt</p>
      </div>
    </div>
  </footer>
</main>

</body>
</html>

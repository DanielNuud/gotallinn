# 🚍 GoTallinn - Public Transport App

Real-time public transportation application for Tallinn, Estonia. Backend API built with Spring Boot, providing schedule information for buses, trams, and trolleybuses.

> **Note:** This is a pet project created for learning purposes and portfolio demonstration.

---

## 🎨 Design

Mobile app UI/UX mockups created in Figma:

[![View in Figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white)](https://www.figma.com/design/G0sIoZLGIEzl6yJV8Z8Ygb/GoTallinn?node-id=0-1&t=SCoFqh7V8pUfViyo-0)

**Includes:**
- 🗺️ Map view with nearby stops
- 📍 Stop details & real-time arrivals
- 🚌 Route information
- 🔍 Search functionality

> Designs are work in progress. Final implementation may vary.

---

## 🎯 Features

-  View real-time schedules for any stop in Tallinn
-  Get route information and trip details
-  Filter arrivals by time
-  Support for GTFS (General Transit Feed Specification) data
-  Mobile application
-  Real-time vehicle tracking
-  Route planning between two points

---

## 🛠️ Tech Stack

### Backend
- **Java 21** - Modern Java features
- **Spring Boot 3.x** - REST API framework
- **Spring Data JPA** - Database interaction
- **Hibernate** - ORM
- **PostgreSQL** - Database
- **Lombok** - Boilerplate reduction
- **Apache Commons CSV** - GTFS data parsing

### Frontend (Planned)
- React Native / Flutter (TBD)

---

## 🗄️ Database Schema

The application uses GTFS (General Transit Feed Specification) format with the following main entities:
```
Agency → Routes → Trips → StopTimes → Stops
              ↓
           Calendar → CalendarDates
```

**Key Tables:**
- `agency` - Transport operators (TLT, etc.)
- `routes` - Bus/tram/trolleybus lines
- `stops` - Physical stop locations
- `trips` - Scheduled vehicle runs
- `stop_times` - Arrival/departure times at each stop
- `calendar` - Service schedule (weekdays/weekends)
- `calendar_dates` - Exceptions (holidays, special dates)

---

## 🗺️ Roadmap

- [x] Database design and entity mapping
- [x] GTFS data import
- [ ] Basic REST API
- [ ] Real-time vehicle positions
- [ ] Route planning algorithm
- [ ] Mobile application (React Native/Flutter)
- [ ] Push notifications for delays
- [ ] Favorite stops/routes
- [ ] Offline mode
- [ ] Multi-city support (Tartu, Pärnu)

---

## 👤 Author

**Daniel Nuud**

- GitHub: [@DanielNuud](https://github.com/DanielNuud)
- LinkedIn: [Daniel Nüüd](https://linkedin.com/in/daniel-nüüd)

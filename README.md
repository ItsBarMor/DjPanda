# DjPanda 🎧🐼
DjPanda is an Android app project, designed for nightlife: matching DJs, clubs, and clubbers.

The goal is to make it easy to discover DJs by genre and location, view profiles, and support future booking and review flows.

## Concept
Music events depend heavily on the right vibe. Since DJs specialize in different styles (EDM, trance, hip-hop, techno, and more), clubs and audiences need a simple way to find the best match.

## DjPanda helps connect:
* DJs presenting their profile and style
* Clubbers exploring DJs and parties

## Current Features
* Navigation-based multi-screen structure using Fragments
* DJ profile screen with DJ details (name, genres, locations, bio, rating, reviews)

## Screens included in the project:
* Home Screen
* DJ Profile
* Party Profile
* Buying Tickets
* Sign In
* Sign Up

## Tech Stack
* Android Studio
* Java
* XML Layouts
* Fragments + Navigation Component (navgraph.xml)
* Local data models

## Project Structure (High-Level)
data/
App-level data access and storage utilities

models/
Data models used across the app

res/layout/
XML UI layouts for fragments and screens

res/navigation/navgraph.xml
Navigation graph controlling screen flow

## How to Run
* Clone the repository using GitHub Desktop:
* File → Clone repository
* Open the project in Android Studio.
* Let Gradle sync and finish indexing.
* Run on an Android Emulator or a physical Android device.

## Roadmap (Planned)
* Authentication flow improvements (Sign In and Sign Up)
* Search and filtering DJs by genre and location
* Reviews and ratings system
* Booking request flow (club → DJ)

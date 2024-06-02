<div align="center">

# singtome: Back-end

*introducing the Back-end project used in the SINGTOME project.*

[![Static Badge](https://img.shields.io/badge/language-english-red)](./README.md) [![Static Badge](https://img.shields.io/badge/language-korean-blue)](./README-KR.md) [![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FSinging-voice-conversion%2Fsingtome-model&count_bg=%23E3E30F&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

</div>

<br>

Hello, and thank you for visiting. This GitHub repository contains the implementation code for the model used in the singtome project. If you're interested in learning more about the singtome project, please refer to [this link](#). 
<br>

<div align="center">

</div>

## Contents
1. [Members](#1-members)
2. [Introduction](#2-introduction)
3. [Swagger Page (Figma)](#3-screen-planning-figma)
4. [Screen Composition](#4-screen-composition)
5. [Used Languages, Libraries, Frameworks, Tools](#5-used-languages-libraries-frameworks-tools)

## 1. Members
| Profile | Name | Role |
| :---: | :---: | :---: |
| <a href="https://github.com/anselmo228"><img src="https://avatars.githubusercontent.com/u/24919880?v=4" height="120px"></a> | Heechan Chung <br> **anselmo**| Restful API with Spring Boot and AWS RDS|

## **2. Introduction**

The Sing-To-Me website is a platform where you can create new songs by overlaying different voices onto original tracks. Users can upload various voice files to train models, and then choose original songs and trained voices to blend together, creating new vocal combinations. Key features include:

- User login and management
- Uploading voice files and training models
- Blending original songs with trained voices to synthesize new songs
- Song playback
- Providing a Top100 list of popular songs

## **3. Swagger Page**
<img width="1451" alt="Screenshot 2024-05-31 at 4 45 07 PM" src="https://github.com/Singing-voice-conversion/Backend/assets/24919880/2c70592d-79f7-40f4-b10b-a22270d7b9b7">

- **Voice API*: Controlls every request against Voice List(Create, Read, Modify, Delete)
- **AI Cover Song API*: Controlls every request against Voice List(Create, Read, Modify, Delete) and Checking if the RVC model is running or not.


## **4. Screen Composition**

### **4.1 Folder Structure**
<img width="298" alt="Screenshot 2024-05-31 at 5 10 07 PM" src="https://github.com/Singing-voice-conversion/Backend/assets/24919880/a052b4c2-1a22-47dd-8cd1-6b34cc3bb7e1">

The project's folder structure is as follows:
According to MVC pattern of Spring boot. We folderized every contents in to Model, Controllers and Service.
Each domain has own Model Contollers and Services.

## **5. Used Languages, Libraries, Frameworks, Tools**

The languages, libraries, frameworks, and tools used in the project are as follows:

- **Languages**: Java, Spring, SQL 
- **Libraries and Frameworks**: 
- **Tools**: Intellij

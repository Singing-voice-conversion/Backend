<div align="center">

# singtome: Back-end

*introducing the Back-end project used in the SINGTOME project.*

*introducing the AI models used in the SINGTOME project.*

[![Static Badge](https://img.shields.io/badge/language-english-red)](./README.md) [![Static Badge](https://img.shields.io/badge/language-korean-blue)](./README-KR.md) [![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2FSinging-voice-conversion%2Fsingtome-model&count_bg=%23E3E30F&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

</div>

<br>

Hello, and thank you for visiting. This GitHub repository contains the implementation code for the model used in the singtome project. If you're interested in learning more about the singtome project, please refer to [this link](#). The project utilizes the RVC (Retrieval Voice Conversion) model to implement vocal transformation features in music. You can find the core implementation of the model [here](https://github.com/RVC-Project/Retrieval-based-Voice-Conversion-WebUI). For more detailed information on how to use the RVC model and its principles, please consult the linked RVC repository.

<br>

<div align="center">

</div>

## Contents
1. [Members](#1-members)
2. [Introduction](#2-introduction)
3. [Screen Planning (Figma)](#3-screen-planning-figma)
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

Screen planning was carried out using Figma to design the overall UI/UX and define the layout and functionality of each page. The main screens and planning intentions are as follows:

- **Login Page**: Controls user authentication and access.
- **Main Page**: Introduces main functions and provides access links.
    - Platform description and usage guide (center banner)
    - List of songs synthesized by the user (small banner)
    - List of songs liked by the user (small banner)
    - List of voices trained by the user (small banner)
- **Top100 Page**: Provides a list of popular songs and playback functionality.
- **Synthesis Page**: Provides an interface for song synthesis inference.
- **Training Page**: Provides an interface for uploading voice files and training models.
- **My Synthesized Songs Page**: Provides a list of songs synthesized by the user.
- **My Liked Songs Page**: Provides a list of songs liked by the user.
- **My Trained Voices Page**: Provides a list of voices trained by the user.

## **4. Screen Composition**

### **4.1 Folder Structure**

The project's folder structure is as follows:

![1](https://github.com/Singing-voice-conversion/Front/assets/124601567/5d3dd759-980a-4b01-b77b-6432db28648d)  
![2](https://github.com/Singing-voice-conversion/Front/assets/124601567/0b14dacb-a13b-4cee-b9a9-f7bef8df87f5)


## **5. Used Languages, Libraries, Frameworks, Tools**

The languages, libraries, frameworks, and tools used in the project are as follows:

- **Languages**: HTML, CSS, JavaScript
- **Libraries and Frameworks**: Vue.js, Vue Router, JQuery
- **Tools**: VScode

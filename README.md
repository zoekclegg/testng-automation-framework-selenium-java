## TestNG Automation Framework with Selenium

This is a TestNG automation framework built using Selenium and Java which uses a page object model. The project automates functional test cases on the website [Selenium Easy](https://demo.seleniumeasy.com/).

### Languages, Frameworks and Tools used

- Java
- Selenium
- TestNG
- Maven
- Extent Reports


### Lessons learned

This project is part of my automation portfolio, the purpose of which is to showcase my automation scripting skills. 
The project also acts as a continuous learning opportunity for myself. Some of the notable learnings (both 
technical and non-technical) from the project are listed below: 

**1. Don't start automating your test unless you know every test step.**
   
I got into the habit of designing my tests as I 
   was writing the code for them. 
   I thought 
   "hey it's 
   just a practice project, it's fine!" But it just made things confusing and I'd end up creating elements and 
   methods I 
   thought 
   I'd 
   need 
   only to realise I didn't actually need them at all. 

**2. Always check your xpath.**
   
Early on in the project I made the mistake of not verifying my xpaths when creating some of my 
   page elements. I then copied and pasted these xpaths and adjusted them for other elements. I didn't discover my 
   xpaths were incorrect until I tried running my tests. ChroPath and the browser console are your friends!
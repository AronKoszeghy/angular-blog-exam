# Exam: Blog engine

### Preparing

- Clone your repository to your computer
- Commit your changes frequently!
- Go through the whole description before starting it!

### What are the rules?

- Please work individually
- ChatGPT and Phind usages are not allowed
- Be careful when copy-pasting parts from previous projects
- Take your time to plan your software (domain objects, software layers, urls, components etc.)
- Always check the acceptance criteria before finishing a user story
- You can complete the user stories in any order you want

### Technical requirements

- Use a Maven project
- Use SpringBoot with JPA
- Use MySQL to store the data
- Use Bootstrap to make it cool looking, create a navigation bar
- Use Logback to log what is happening
- Use Angular for frontend

### Brief description 

Create a simple blog engine that people can use to post their ideas. On every post users can leave
comments which are displayed under it. 

### User stories:

#### 0. Backlog item: Config (2 points)

- Create the project layout (necessary folders and packages)
- Create the database
- Create the angular app
- Add required css and js files

#### 1. US: New post (12 points)

As a user, I want to create a new post on a website and want to make sure that it is stored in a persistent database (like Mysql), 
so I can store my memories in long term. 

Post properties/fields:
- title (String, mandatory)
- text (String, mandatory)
- feature image url (String, optional)
- createdAt (LocalDateTime, not given by user, but server sets it)  

**Acceptance criteria:**
- The form is shown when opening the "New post" page in a browser (1p)
- The form has all necessary fields (except createdAt) and a Save button (3p)
- In case of no error, the post data is stored in the database (use DTOs) (5p) 
- The input is validated and validation errors are shown (2p)
- Server logging: "New post is created" is logged (using Logback or slf4j) to the server console (1p) 

#### 2. US: Post list (10 points)

As a user, I want to see my posts in a list sorted in descending order by createdAt, so I can see an overview of them. 

Post's fields to display in the list:
- featureImage
- title
- body (maximum 200 chars). If the text is longer, it should be cut.
- createdAt

**Acceptance criteria:**
- The posts are displayed with all fields (if necessary use DTOs) (3p)
- The text is cut, if it is longer than 200 chars (2p)
- The order of posts is correct (2p)
- A button or link is displayed to create "new post" (eg. in the navbar) (1p) 
- After saving a post, the user is redirected here to the Post list page (1p)
- Server logging: "Post list page is requested" is logged to the console (1p) 

**NOT list:**
- there is no modify and delete post function

#### 3. US: Post details (6 points)

As a user, if I click on a post's title, I want to see the post in a separate "Post details" page with all of its data.

**Acceptance criteria:**
- On the "Post list" page the title is clickable (it is a link) for every post that takes to the "Post details" page (3p)
- All post fields appear (with full length of the text, use DTOs) (3p)
  
#### 4. US: Post comment (13 point)

As a user, I want to leave comments for posts, so I want to have an "Add comment" button or link on the Post page. 
I want to see a comment form with the input fields below. 

Comment properties/fields:
- author (String, optional)
- text (String, mandatory)
- createdAt (LocalDateTime, not given by user, but server sets it)
- (relation to the Post it belongs to) 

**Acceptance criteria:**
- The comment button or link is shown when opening a Post page (the form can be on a separate page or on the "Post details" page),
the form that has all necessary fields (author and text) and a 'Save comment' button (4p)
- In case of no error, the comment data is stored in the database (use DTOs) (5p)
- The input is validated and validation errors are logged (3p)
- Server logging: "New comment is created" is logged to the console (1p) 
  

**NOT list:**
- there is no modify and delete comment function

#### 5. US: Comments under post details (7 point)

As a user I want to see all my comments (with all their data) under the Post sorted in descending order by createdAt.

Hint: use @OrderBy to get the list of comments in a specific order. 
 ```` 
     @OrderBy(value = "createdAt desc")
     private List<Comment> comments = new ArrayList<>();
 ````

**Acceptance criteria:**
- The post's comments are shown with all fields (use DTOs) (3p)
- In descending order by createdAt (2p)
- After submitting a new comment, it appears in this list (2p)


## License 
Copyright © Progmasters (QTC Kft.), 2016-2023.
All rights reserved. No part or the whole of this Teaching Material (TM) may be reproduced, copied, distributed, publicly performed, disseminated to the public, adapted or transmitted in any form or by any means, including photocopying, recording, or other electronic or mechanical methods, without the prior written permission of QTC Kft. This TM may only be used for the purposes of teaching exclusively by QTC Kft. and studying exclusively by QTC Kft.’s students and for no other purposes by any parties other than QTC Kft.
This TM shall be kept confidential and shall not be made public or made available or disclosed to any unauthorized person.
Any dispute or claim arising out of the breach of these provisions shall be governed by and construed in accordance with the laws of Hungary. 

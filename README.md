# Hotel Bookings API

API for the Hotel Bookings PBL Practice Project

Deploying a backend API to Heroku allows developers and products to utilize a centralized instance
of the application. By instantiating the
application remotely, the developer can also gain some level of confidence that the application is
behaving as expected by not relying on local
configurations.

## Steps

### Initial Heroku Setup

1. Log into or create a Heroku account.
2. From the dashboard, create a new application by first pressing the 'New' button, then select
   the 'Create new app' option from the dropdown
   menu.
3. Enter the desired app name by inputting the URL you would like to use for the application, then
   click the 'Create app' button. Note: This name must be unique among all Heroku apps. The input
   box will verify the name before allowing you to continue.
4. If you haven't already done so, download and install the Heroku CLI tools for your OS.

### Deploying the Application:

1. In a Git terminal, enter `heroku login` and continue through prompts in the terminal. (Note: This
   may pull upa login interface in your default internet browser)
2. Ensure you are on the branch you would like to deploy to Heroku, and then add the Heroku remote
   with the following command: `heroku git: remote -a <heroku-application-name>` Note: You can
   verify the git remote is connected with the command `git remote -v` and verify it’s pointing at
   the heroku remote application)
3. Add the files to push to the Heroku remote application running `git add .`
4. Commit the changes by running `git commit -m "<commit message>"`
5. Finally, push the changes to the remote by running `git push heroku <branchname to push>:main`
6. After Heroku finishes building and applying the changes, you should be able to navigate to the
   heroku address and utlize the application or hit it via Postman. Typical address naming
   is `https://<heroku-application-name>.herokuapp.com`

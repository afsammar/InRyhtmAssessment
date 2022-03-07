Pagination Helper Task

In this project I have used both Maven and TestNG for unit testing. After completing the clonning of this project to your local, please follow the below lines to execute this project.

Project path must be specified on the terminal cd project path

command for executing all tests -----> mvn -Dtest=PaginationHelperTest.PaginationHelperTest test

command for executing a specific test case ----->mvn -Dtest=PaginationHelperTest.PaginationHelperTest#getItemCount test mvn -Dtest=PaginationHelperTest.PaginationHelperTest#getPageIndex test mvn -Dtest=PaginationHelperTest.PaginationHelperTest#getPageCount test mvn -Dtest=PaginationHelperTest.PaginationHelperTest#getPageItemCount test

For execution without commands -----> test resources > runner package, then execute runnertest.xml file
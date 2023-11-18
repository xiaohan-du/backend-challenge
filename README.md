# backend-challenge

## Run the application:
Gradle - bootRun

## Demo walkthrough
* Reset the database: open Datagrip, open `src/main/resources/Loan_Database.sql`, `ctrl + A` to select all scripts, then `ctrl + enter` to run it to reset the database.
* Run the application: Gradle - bootRun
* In Postman, create a `POST` request to `http://localhost:8080/api/loans/new` with the following query params:
![image](https://github.com/xiaohan-du/backend-challenge/assets/16627563/5803e20d-5ff4-47b3-9370-8c176045a3e8)
* In Postman, create a `GET` request to `http://localhost:8080/api/loans` to retrive a list of loan details:
![image](https://github.com/xiaohan-du/backend-challenge/assets/16627563/1e8dac00-91e5-4733-93e6-7022be0ff1e8)



## API endpoints:
### Endpoint
GET `/api/loans`
### Description
Retrieve a list of loan details. **When application first run, it should return `[]` as database is empty.**
### Example response
```
[
    {
        "id": 1,
        "payment": 262.8794859562353,
        "principal": 237.87948595623533,
        "interest": 25,
        "balance": 19762.120514043763
    },
    {
        "id": 2,
        "payment": 262.8794859562353,
        "principal": 238.1768353136806,
        "interest": 24.702650642554705,
        "balance": 19523.94367873008
    }
]
```

### Endpoint
POST `/api/loans/new`
### Description
Create a new loan based on a schedule
### Query Parameters
* `id` (_Integer_): use 1 as a dummy value
* `balloonPayment` (_Double_): the optional balloon payment at the end. If not exist, put 0.0
* `yearlyInterestRate` (_Double_): the interest rate for a whole year
* `repayMonths` (_Integer_): the number of months user wants to split
* `assetCost` (_Double_): the cost of the asset being financed
### Example Postman Query
![image](https://github.com/xiaohan-du/backend-challenge/assets/16627563/95844131-ce64-440c-bc69-94ec4d4ae7a7)

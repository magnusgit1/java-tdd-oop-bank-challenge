
| Class    | Method                                   | Scenario                                    | Output |
|----------|------------------------------------------|---------------------------------------------|--------|
| Customer | createCurrentAccount()                   | If current account already exists           | false  |
|          |                                          | If no current account exists                | true   |
|          |                                          |                                             |        |
| Customer | createSavingsAccount()                   | If savings account already exists           | false  |
|          |                                          | If no savings account exists                | true   |
|          |                                          |                                             |        |
| Customer | generateBankStatements(Account account)) | If account does not exist                   | null   |
|          |                                          | If account exists                           | String |
|          |                                          |                                             |        |
| Customer | deposit(Account account, int amount)     | If amount < 0                               | false  |
|          |                                          | If amount is > 0                            | true   | 
|          |                                          |                                             |        |
| Customer | withdraw(Account account, int amount)    | If amount is larger than balance            | false  |
|          |                                          | If amount is less or equal to balance       | true   |
|          |                                          |                                             |        |
| Bank     | createCurrentAccount(Customer customer)  | If customer has a current account           | false  |
|          |                                          | If customer does not have a current account | true   |
|          |                                          |                                             |        |
| Bank     | createSavingsAccount(Customer customer)  | If customer has a savings account           | false  |
|          |                                          | If customer does not have a savings account | true   |
|          |                                          |                                             |        |
| Bank     | generateStatement(Account account)       | If account does not exist                   | null   |
|          |                                          | If account exists                           | String |
|          |                                          |                                             |        |
| Account  | deposit(int amount)                      | If amount is < 0                            | false  |
|          |                                          | If amount is > 0                            | true   | 
|          |                                          |                                             |        |
| Account  | withdraw(int amount)                     | If amount is larger than balance            | false  |
|          |                                          | If amount is less or equal to balance       | true   |
|          |                                          |                                             |        |
| Account  | generateStatement()                      | If list of statements is empty              | null   |
|          |                                          | If list of statements is not empty          | String |
|          |                                          |                                             |        |
|          |                                          |                                             |        |

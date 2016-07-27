Feature: Test if f1 feature is working
Scenario: valid scenario
Given push home
Given close app "com.android.vending"
Given start app "com.android.vending"
Then Page should be "TopPage"
Given app name input is "test"
Then result should contain 3rd
Given push home

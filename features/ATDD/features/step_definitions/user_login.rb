When(/^I input '(.*)' as '(.*)'$/) do |field, value|
  @loginScreen = page(LoginScreen).await
  @loginScreen.userLogin(value)
end

When(/^I decide to (Cancel|Save) this equipment$/) do |button|
end

And(/^I decide to Login$/) do
  touch("* id:'somethingId'")
end

Then(/^I should see display name and number of orders$/) do
  user = query("* id:''").values[4]
  should_see_text(user)
end

Then(/^I should see the error message "([^"]*)"$/) do |arg|
  should_see_text(arg)
end


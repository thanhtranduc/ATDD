When(/^I input '(.*)' as '(.*)'$/) do |field, value|
  @loginScreen = page(LoginScreen).await
  @loginScreen.userLogin(field, value)
end

When(/^I decide to (Cancel|Save) this equipment$/) do |button|
  sleep(1)
  if button.eql?('Save')
    touch("* id:'dialog_add_order_btSave'")
  else
    touch("* id:'dialog_add_order_btCancel'")
  end
end

And(/^I decide to Login$/) do
  touch("* id:'login_btLogin'")
end

Then(/^I should see display name and number of orders$/) do
  display_name = CUSTOMERS[:Tim][:display_name]
  expect_name = "Hello "+ display_name
  list_order =CUSTOMERS[:Tim][:order_list].length
  expect_display_orders =  "You have " + list_order.to_s + " orders"
  sleep(1)
  check_element_exists("* text:'#{expect_name}'")
  sleep(1)
  check_element_exists("* text:'#{expect_display_orders}'")
end

Then(/^I should see the error message "([^"]*)"$/) do |arg|
  should_see_text(arg)
end

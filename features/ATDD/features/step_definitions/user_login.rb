When(/^I input '(.*)' as '(.*)'$/) do |field, value|
  input_data(field, value)
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

Then(/^I should see the error message "([^"]*)"$/) do |arg|
  should_see_text(arg)
end


Then(/^I should see display name$/) do
  display_name = CUSTOMERS[:tim][:display_name]
  expect_name = "Hello "+ display_name
  sleep(1)
  check_element_exists("* text:'#{expect_name}'")
end
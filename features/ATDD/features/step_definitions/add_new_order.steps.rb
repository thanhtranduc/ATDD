Given(/^I am on order list screen of (.*)$/) do |customer|
  @loginScreen = page(LoginScreen).await
  #@loginScreen.screen_type("Login")
  #@loginScreen.await
  puts customer
  @loginScreen.userLogin("username", customer)
  pass = CUSTOMERS[customer.to_sym][:password]
  @loginScreen.userLogin("password", pass)
  sleep(1)
  touch("* id:'login_btLogin'")

end

And(/^I select add new order$/) do
  sleep(1)
  touch("* id:'list_goods_btAdd'")
end

Then(/^I am on Add Order Screen$/) do
  @addOder = page(AddOrder).await
end

When(/^I input field '(.*)' as '(.*)'$/) do |field, value|
  @addOder.inputData(field,value)
end

Then(/^I should see new order in my order list$/) do
  should_see_text('00111')
  should_see_text('20000')
end
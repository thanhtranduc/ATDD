Given(/^I login successfully as '(.*)'$/) do |customer|
  @loginScreen = page(LoginScreen).await
  puts customer
  @loginScreen.userLogin("username", customer)
  pass = CUSTOMERS[customer.to_sym][:password]
  @loginScreen.userLogin("password", pass)
  sleep(1)
  touch("* id:'login_btLogin'")
end

def get_bill_from_hash(row_hash)
  order = {}
  order[:order_code] = get_order_price(row_hash.to_sym)
  order[:amount] = get_amount_of_order(row_hash.to_sym)
  order[:description] = get_description_of_order(row_hash.to_sym)
  order
end

def get_order_price(order_hash_to_sym)
  ORDER[order_hash_to_sym][:order_code]
end
def get_amount_of_order(order_hash_to_sym)
  ORDER[order_hash_to_sym][:amount]
end
def get_description_of_order(order_hash_to_sym)
  ORDER[order_hash_to_sym][:description]
end

Then(/^I should see number of orders$/) do
  list_order =CUSTOMERS[:tim][:order_list].length
  expect_display_orders =  "You have " + list_order.to_s + " orders"
  sleep(1)
  check_element_exists("* text:'#{expect_display_orders}'")
end

And(/^I should see order price of customer and total price$/) do |table|
  @user_detail = page(UserDetail).await
  total = 0;
  table.hashes.each do |row|
    row_hash = row[:order]
    row_price = get_bill_from_hash(row_hash)
    total += row_price[:amount].gsub(',','').to_i
    puts row_price
    @user_detail.check_order_exist(row_price, msg = "order '#{row_hash}' does not rendered" )
  end
  expect_total = format_money("%.2f"%(total)).to_s +" VNĐ"
  should_see_text(expect_total)
end
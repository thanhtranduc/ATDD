Given(/^I login successfully as '(.*)'$/) do |customer|
  @loginScreen = page(LoginScreen).await
  puts customer
  @loginScreen.userLogin("userName", customer)
  pass = CUSTOMERS[customer.to_sym][:password]
  @loginScreen.userLogin("password", pass)
  sleep(1)
  touch("* id:'login_btLogin'")
end


And(/^I should see order price of customer$/) do |table|
  @user_detail = page(UserDetail).await
  table.hashes.each do |row|
    row_hash = row[:order]
    row_price = get_bill_from_hash(row_hash)
    puts row_price
    @user_detail.check_order_exist(row_price, msg = "order '#{row_hash}' does not rendered" )
  end
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
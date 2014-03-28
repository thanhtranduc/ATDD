require 'postgres'

Before('@customer_order') do
  require_relative "../../features/test_data/CustomerProfileTestData"
end

After('@unit_list') do
  #setup_db("features/middle_tier/gen/sql/unit_list.sql")
end

After('@manage_unit') do
  #setup_db("features/test_data/sql/basic_information_customer.sql")
end

Before('@manage_unit') do
  require_relative "../../features/test_data/manage_unit"
end

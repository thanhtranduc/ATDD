require 'postgres'

Before('@customer_order') do
  require_relative "../../features/test_data/CustomerProfileTestData"
end

After('@customer_order') do
  #setup_db("features/middle_tier/gen/sql/unit_list.sql")
end

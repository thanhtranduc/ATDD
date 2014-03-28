require 'calabash-android/abase'

class AddOrder < Calabash::ABase
  def trait
    "* text:'Add Order'"
  end


  def await(opts={})
    timeout = 10
    msg = "time out to wait for Login screen appear"
    options = {:timeout => timeout.to_i,
               :retry_frequency => 0.2,
               :post_timeout => 0.1,
               :timeout_message => msg}
    wait_for_elements_exist([trait], options)
    self
  end

  def inputData(field, value)
    input_data(field,value)
  end

end
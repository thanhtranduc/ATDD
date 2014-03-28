require 'calabash-android/abase'

class LoginScreen < Calabash::ABase
  def trait
    "* id:'launchScreen'"
  end


  def await(opts={})
    timeout = 20
    msg = "time out to wait for Login screen appear"
    options = {:timeout => timeout.to_i,
               :retry_frequency => 0.2,
               :post_timeout => 0.1,
               :timeout_message => msg}
    wait_for_elements_exist([trait], options)
    self
  end

  def customerLogin(customer)
    touch("button text:'#{customer}'")
    sleep(STEP_PAUSE)
  end

end
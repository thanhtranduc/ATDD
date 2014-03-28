require 'calabash-android/abase'

class LoginScreen < Calabash::ABase

  #def screen_type(page_type)
  #  @page_type = page_type
  #end
  #
  #def get_screen_type
  #  @page_type
  #end

  def trait
    #trait_string = ''
    #if @page_type == "Login"
      trait_string = "* id:'login_main'"
    #else
    #  trait_string = "* id:'dialog_add_order_main'"
    #end
    #trait_string
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

  def userLogin(field, value)
    sleep(1)
   input_data(field,value)
  end
end
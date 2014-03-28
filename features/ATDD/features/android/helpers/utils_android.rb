#def click_on_drawer
#  await_element_with_id('flash_layout_ivFakeHandle')
#  touch("* id:'flash_layout_ivFakeHandle'")
#  sleep(STEP_PAUSE)
#end
#
#def select_customer_app
#  touch("* id:'drawer_ivCustomer'")
#  sleep(STEP_PAUSE)
#end
#

def input_data(field, value)
  if field.eql?('userName')
    query("* id:'login_etUserName'", setText: "#{value}")
    sleep(STEP_PAUSE)
  elsif field.eql?('password')
    sleep(STEP_PAUSE)
    query("* id:'login_etPass'", setText: "#{value}")
  elsif field.eql?('order_code')
    sleep(STEP_PAUSE)
    query("* id:'dialog_add_order_etNo'", setText: "#{value}")
  elsif field.eql?('amount')
    sleep(STEP_PAUSE)
    query("* id:'dialog_add_order_etAmount'", setText: "#{value}")
  end
end

def should_see_text (text)
  puts text
  if text.length > 0
    await_element_with_text(text)
    check_element_exists("* text:'#{text}'")
  end
end

#
#def convert_and_should_see_text(text)
#  if text!= "0.00" and text!=""
#    #while text.sub!(/(\d+)(\d\d\d)/,'\1,\2'); end
#    should_see_text("$ "+ text)
#  end
#end
#
def check_exist_text(text)
  puts text
  if text.length > 0
    q = query("* text:'#{text}'")
    while q.empty?
      performAction('scroll_down')
      q = query("* text:'#{text}'")
    end
    check_element_exists("* text:'#{text}'")
  end
end

def await_element_with_id(id)
  timeout = 100
  msg = "time out to wait for id #{id} appear"
  options = {:timeout => timeout.to_i,
             :retry_frequency => 0.2,
             :post_timeout => 0.1,
             :timeout_message => msg}
  wait_for_elements_exist(["* id:'#{id}'"], options)
end

def await_element_with_text(text)
  timeout = 100
  msg = "time out to wait for text #{text} appear"
  options = {:timeout => timeout.to_i,
             :retry_frequency => 0.2,
             :post_timeout => 0.1,
             :timeout_message => msg}
  wait_for_elements_exist(["* text:'#{text}'"], options)
end

def should_see_field(id, text)
  await_element_with_id(id)
  text_expect = query("* id:'#{id}'", :text)[0]

  timeout = 20
  msg = "can not wait for #{id} appear"
  options = {:timeout => timeout.to_i,
             :retry_frequency => 0.2,
             :post_timeout => 0.1,
             :timeout_message => msg}
  while check_element_exists("* id:'#{id}'")
    performAction('scroll_down')
  end
  if (!text_expect.eql?(text))
    screenshot_and_raise "text of #{id} should be #{text}"
  end
end

def fake_to_unit_list_screen
  puts "before fake"
  sleep(1)
  performAction("wait_for_no_progress_bars")
  touch("* id:'main_btShowMake'")
end

def move_to_available_detail_screen(unit)
  touch("* id:'main_btShowMake'")
  touch("* text:'CVZ'")
  touch("* text:'CVZ'")
  touch("* text:'CA'")
end

def select_login
  touch("* id:'main_btShowMake'")
end


def fake_go_to_favorites_list
  sleep STEP_PAUSE
  touch "* text:'All Makes'"

  sleep STEP_PAUSE
  sleep STEP_PAUSE
  sleep STEP_PAUSE
  touch "* text:'Favorites'"
  sleep STEP_PAUSE
  sleep STEP_PAUSE
end

def fake_go_to_scanned_out_list
  sleep STEP_PAUSE
  touch "* text:'All Makes'"

  sleep STEP_PAUSE
  sleep STEP_PAUSE
  sleep STEP_PAUSE
  touch "* text:'Scanned Out'"
  sleep STEP_PAUSE
  sleep STEP_PAUSE
end

def fake_go_to_untagged_list
  sleep STEP_PAUSE
  touch "* text:'All Makes'"

  sleep STEP_PAUSE
  sleep STEP_PAUSE
  sleep STEP_PAUSE
  touch "* text:'Untagged'"
  sleep STEP_PAUSE
  sleep STEP_PAUSE
end

def fake_go_to_nearby_list
  sleep STEP_PAUSE
  touch "* text:'All Makes'"

  sleep STEP_PAUSE
  sleep STEP_PAUSE
  sleep STEP_PAUSE
  touch "* text:'Nearby'"
  sleep STEP_PAUSE
  sleep STEP_PAUSE
end

def fake_move_all_make_screen
  touch("* text:'SHOW MAKES'")
end


setlocal
cd rails
ruby .\bin\determinator
CALL gem install bundler
bundle install
bundle exec rake db:setup